package bd.com.appupdate.util;


import com.liulishuo.filedownloader.BaseDownloadTask;

public interface DownLoadCallBack {
    void pending(BaseDownloadTask task, long soFarBytes, long totalBytes);
}
