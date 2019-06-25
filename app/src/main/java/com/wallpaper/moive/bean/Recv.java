package com.wallpaper.moive.bean;

/**
 * @author The one
 * @date 2018/7/20 0020
 * @describe TODO
 * @email 625805189@qq.com
 * @remark
 */
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

public class Recv {

    protected String title = null;
    protected String content = null;
    protected ArrayList<Uri> uris = null;
    protected Intent intent = null;

    public Recv(Intent intent) {
        this.intent = intent;
        this.resolve();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Uri> getUris() {
        return uris;
    }

    public void setUris(ArrayList<Uri> uris) {
        this.uris = uris;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public boolean isActionSend() {
        return this.intent != null && Intent.ACTION_SEND.equals(intent.getAction());
    }

    private void resolve() {
        this.title = this.content = null;
        this.uris = null;

        Intent intent = this.getIntent();

        if (intent == null || !Intent.ACTION_SEND.equals(intent.getAction()))
            return;

        String type = intent.getType();
        String action = intent.getAction();

        if (type == null || action == null)
            return;

        if ("text/plain".equals(type)) {
            this.title = intent.getStringExtra(Intent.EXTRA_TITLE);
            this.content = intent.getStringExtra(Intent.EXTRA_TEXT);
        } else if (type.startsWith("image/")) {
            //接收多张图片
            if (action.equals(Intent.ACTION_SEND_MULTIPLE)) {
                this.uris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
            } else {
                Uri uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                this.uris = new ArrayList<>();
                this.uris.add(uri);
            }
        }
    }
}