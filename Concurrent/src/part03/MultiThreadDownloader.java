package part03;

import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangchen
 * @version 1.0
 */

public class MultiThreadDownloader {

    // 下载线程类
    static class DownloadThread extends Thread {
        private final String url;
        private final long start;
        private final long end;
        private final File file;
        private final AtomicInteger progress;

        public DownloadThread(String url, long start, long end, File file, AtomicInteger progress) {
            this.url = url;
            this.start = start;
            this.end = end;
            this.file = file;
            this.progress = progress;
        }

        @Override
        public void run() {
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestProperty("Range", "bytes=" + start + "-" + end);
                conn.connect();

                try (InputStream in = conn.getInputStream();
                     RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
                    raf.seek(start);

                    byte[] buffer = new byte[4096];
                    int len;
                    while ((len = in.read(buffer)) != -1) {
                        raf.write(buffer, 0, len);
                        progress.addAndGet(len);  // 更新进度
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 进度监控线程
    static class ProgressMonitor extends Thread {
        private final long totalSize;
        private final AtomicInteger progress;

        public ProgressMonitor(long totalSize, AtomicInteger progress) {
            this.totalSize = totalSize;
            this.progress = progress;
        }

        @Override
        public void run() {
            try {
                while (progress.get() < totalSize) {
                    System.out.printf("下载进度：%.2f%%%n", progress.get() * 100.0 / totalSize);
                    Thread.sleep(1000);
                }
                System.out.println("下载完成！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 主方法
    public static void main(String[] args) throws Exception {
        String fileURL = "https://speed.hetzner.de/100MB.bin"; // 可替换成你要下载的文件URL
        int threadCount = 4;
        String fileName = "downloaded_file.bin";

        // 获取文件大小
        HttpURLConnection conn = (HttpURLConnection) new URL(fileURL).openConnection();
        conn.setRequestMethod("HEAD");
        long fileSize = conn.getContentLengthLong();
        conn.disconnect();

        System.out.println("文件总大小: " + fileSize + " 字节");

        File outputFile = new File(fileName);
        RandomAccessFile raf = new RandomAccessFile(outputFile, "rw");
        raf.setLength(fileSize); // 设置文件大小
        raf.close();

        long blockSize = fileSize / threadCount;
        AtomicInteger progress = new AtomicInteger(0);

        // 启动进度监控线程
        Thread monitor = new ProgressMonitor(fileSize, progress);
        monitor.start();

        // 启动下载线程
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            long start = i * blockSize;
            long end = (i == threadCount - 1) ? fileSize - 1 : (start + blockSize - 1);
            threads[i] = new DownloadThread(fileURL, start, end, outputFile, progress);
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            thread.join();
        }

        monitor.join(); // 等待进度线程结束
        System.out.println("文件下载并合并完成！");
    }
}
