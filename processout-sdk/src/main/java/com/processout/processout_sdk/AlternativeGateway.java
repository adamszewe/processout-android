package com.processout.processout_sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.gson.annotations.SerializedName;

public class AlternativeGateway {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("enabled")
    private boolean enabled;
    @SerializedName("default_currency")
    private String defaultCurrency;
    @SerializedName("gateway")
    private Gateway gateway;

    private String invoiceId;
    private String projectId;
    private Context context;

    /**
     *
     */
    public void redirect() {
        WebView theWebPage = new WebView(this.context);
        theWebPage.getSettings().setJavaScriptEnabled(true);
        theWebPage.getSettings().setPluginState(WebSettings.PluginState.ON);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://checkout.processout.ninja/" + this.projectId + "/" + this.invoiceId + "/redirect/" + this.id));
        this.context.startActivity(browserIntent);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
