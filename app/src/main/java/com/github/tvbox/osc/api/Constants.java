package com.github.tvbox.osc.api;

public interface Constants {
    String API_CONFIG = "tv.json";

    String IJK_DEFAULT_CONFIG = "[\n" +
            "    {\n" +
            "      \"group\": \"软解码\",\n" +
            "      \"options\": [\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"opensles\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"overlay-format\",\n" +
            "          \"value\": \"842225234\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"framedrop\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"soundtouch\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"start-on-prepared\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 1,\n" +
            "          \"name\": \"http-detect-range-support\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 1,\n" +
            "          \"name\": \"fflags\",\n" +
            "          \"value\": \"fastseek\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 2,\n" +
            "          \"name\": \"skip_loop_filter\",\n" +
            "          \"value\": \"48\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"reconnect\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"enable-accurate-seek\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"mediacodec\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"mediacodec-auto-rotate\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"mediacodec-handle-resolution-change\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"mediacodec-hevc\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 1,\n" +
            "          \"name\": \"dns_cache_timeout\",\n" +
            "          \"value\": \"600000000\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"group\": \"硬解码\",\n" +
            "      \"options\": [\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"opensles\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"overlay-format\",\n" +
            "          \"value\": \"842225234\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"framedrop\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"soundtouch\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"start-on-prepared\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 1,\n" +
            "          \"name\": \"http-detect-range-support\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 1,\n" +
            "          \"name\": \"fflags\",\n" +
            "          \"value\": \"fastseek\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 2,\n" +
            "          \"name\": \"skip_loop_filter\",\n" +
            "          \"value\": \"48\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"reconnect\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"enable-accurate-seek\",\n" +
            "          \"value\": \"0\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"mediacodec\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"mediacodec-auto-rotate\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"mediacodec-handle-resolution-change\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 4,\n" +
            "          \"name\": \"mediacodec-hevc\",\n" +
            "          \"value\": \"1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"category\": 1,\n" +
            "          \"name\": \"dns_cache_timeout\",\n" +
            "          \"value\": \"600000000\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]";
}
