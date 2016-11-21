package org.soluvas.image;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ceefour on 21/11/2016.
 */
public class Imgix {

    private String host;
    private String path;
    private Map<String, Object> params = new LinkedHashMap<>();

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Imgix host(String host) {
        setHost(host);
        return this;
    }

    public Imgix path(String path) {
        this.path = path;
        return this;
    }

    /**
     * w=256&h=256&fit=crop
     * @return
     */
    public Imgix thumb() {
        return thumb(256);
    }

    /**
     * w=256&h=256&fit=crop
     * @return
     */
    public Imgix thumb(int size) {
        params.put("w", size);
        params.put("h", size);
        params.put("fit", "crop");
        return this;
    }

    @Override
    public String toString() {
        final URIBuilder builder = new URIBuilder().setScheme("https").setHost(host)
                .setPath(path.startsWith("/") ? path : "/" + path)
                .addParameters(params.entrySet().stream()
                        .map(it -> new BasicNameValuePair(it.getKey(), it.getValue().toString())).collect(Collectors.toList()));
        return builder.toString();
    }
}
