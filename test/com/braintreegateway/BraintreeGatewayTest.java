package com.braintreegateway;

import org.junit.Assert;
import org.junit.Test;

public class BraintreeGatewayTest {
    @Test
    public void developmentBaseMerchantUrl() {
        BraintreeGateway config = new BraintreeGateway(Environment.DEVELOPMENT, "integration_merchant_id", "publicKey",
                "privateKey");
        String port = System.getenv().get("GATEWAY_PORT") == null ? "3000" : System.getenv().get("GATEWAY_PORT");
        Assert.assertEquals("http://localhost:" + port + "/merchants/integration_merchant_id", config.baseMerchantURL());
    }

    @Test
    public void sandboxBaseMerchantUrl() {
        BraintreeGateway config = new BraintreeGateway(Environment.SANDBOX, "sandbox_merchant_id", "publicKey", "privateKey");
        Assert.assertEquals("https://sandbox.braintreegateway.com:443/merchants/sandbox_merchant_id", config
                .baseMerchantURL());
    }

    @Test
    public void productionBaseMerchantUrl() {
        BraintreeGateway config = new BraintreeGateway(Environment.PRODUCTION, "production_merchant_id", "publicKey", "privateKey");
        Assert.assertEquals("https://www.braintreegateway.com:443/merchants/production_merchant_id", config.baseMerchantURL());
    }

    @Test
    public void getAuthorizationHeader() {
        BraintreeGateway config = new BraintreeGateway(Environment.DEVELOPMENT, "development_merchant_id",
                "integration_public_key", "integration_private_key");
        Assert.assertEquals("Basic aW50ZWdyYXRpb25fcHVibGljX2tleTppbnRlZ3JhdGlvbl9wcml2YXRlX2tleQ==", config
                .getAuthorizationHeader());
    }
}
