package com.commandus.lorawanpayload;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import java.util.Date;

public class Payload {
    long id;
    Date received;
    String devEui;
    String devName;
    public String hexPayload;
    int frequency;
    int rssi;
    float lsnr;

    public void reset() {
        received = new Date();
        devEui = "";
        devName = "";
        hexPayload = "";
        frequency = 0;
        rssi = 0;
        lsnr = 0.0f;
    }

    public Payload() {
        reset();
    }

    public Payload(
        String payload
    ) {
        reset();
        this.hexPayload = payload;
    }

    public Payload(
        String hexPayload,
        int frequency,
        int rssi,
        float lsnr
    ) {
        id = 0L;
        this.received = new Date();
        this.devEui = "";
        this.devName = "";
        this.hexPayload = "";
        this.frequency = frequency;
        this.rssi = rssi;
        this.lsnr = lsnr;
        this.hexPayload = hexPayload;
    }

    public Payload(
        long id,
        long receeived,
        String devEmui,
        String devName,
        String hexPayload,
        int frequency,
        int rssi,
        float lsnr
    ) {
        this.id = id;
        this.received = new Date(receeived * 1000L);
        this.devEui = devEmui;
        this.devName = devName;
        this.hexPayload = hexPayload;
        this.frequency = frequency;
        this.rssi = rssi;
        this.lsnr = lsnr;
        this.hexPayload = hexPayload;
    }

    public Payload(Payload p) {
        id = p.id;
        received = p.received;
        devEui = p.devEui;
        devName = p.devName;
        hexPayload = p.hexPayload;
        frequency = p.frequency;
        rssi = p.rssi;
        lsnr = p.lsnr;
    }

    @NonNull
    @Override
    public String toString() {
        return "{" +
            "\"id\": \"" + id +
            "\"received\": \"" + received.toString() +
            "\", \"devEui\": \"" + devEui +
            "\", \"devName\": \"" + devName +
            "\", \"hexPayload\": \"" + hexPayload +
            "\", \"frequency\": " + frequency +
            ", \"rssi\": \"" + rssi +
            ", \"lsnr\": \"" + lsnr +
        '}';
    }

    public ContentValues getContentValues() {
        ContentValues r = new ContentValues();
        r.put(PayloadProvider.FN_ID, id);
        r.put(PayloadProvider.FN_RECEIVED, received.getTime() / 1000L);
        r.put(PayloadProvider.FN_DEVEUI, devEui.toString());
        r.put(PayloadProvider.FN_DEVNAME, devName.toString());
        r.put(PayloadProvider.FN_PAYLOAD, hexPayload.toString());
        r.put(PayloadProvider.FN_FREQUENCY, frequency);
        r.put(PayloadProvider.FN_RSSI, rssi);
        r.put(PayloadProvider.FN_LSNR, lsnr);
        return r;
    }
}
