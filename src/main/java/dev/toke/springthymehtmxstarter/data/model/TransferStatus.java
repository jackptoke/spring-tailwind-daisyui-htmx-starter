package dev.toke.springthymehtmxstarter.data.model;

public enum TransferStatus {
    NEW("NEW"),
    COMPLETE("COMPLETE"),
    ARTICLE_EXPORTED("ARTICLE_EXPORTED"),
    JOB_EXPORTED("JOB_EXPORTED"),
    ARTICLE_ERROR("ARTICLE_ERROR"),
    JOB_ERROR("JOB_ERROR");

    private final String value;
    TransferStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
