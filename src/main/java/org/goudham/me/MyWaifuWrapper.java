package org.goudham.me;

/**
 * Returns API information to {@link MyWaifuClient}
 */
class MyWaifuWrapper {
    private final String version = "1.0";
    private final String host = "https://mywaifulist.moe/api/v1/";
    private final String apiKey;

    /**
     * Instantiates an instance of {@link MyWaifuWrapper} to retrieve API Information
     * @param apiKey API Key to authorise API request
     */
    public MyWaifuWrapper(String apiKey) {
        this.apiKey = apiKey;
    }
}
