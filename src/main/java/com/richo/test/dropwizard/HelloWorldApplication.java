package com.richo.test.dropwizard;

import com.richo.test.dropwizard.api.HelloWorldApi;
import com.richo.test.dropwizard.api.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class HelloWorldApplication extends Application<HelloWorldConfiguration>
{
	public static void main(String[] args) throws Exception
	{
		new HelloWorldApplication().run(args);
	}

	@Override
	public String getName()
	{
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap)
	{
		/**
		 * This is intended to load our static content to root,
		 * so that localhost:8080/ shows index.html
		 * and localhost:8080/js/main.js shows main.js
		 */
		AssetsBundle assetsBundle = new AssetsBundle("/assets/", "/", "index.html", "static");
		bootstrap.addBundle(assetsBundle);
	}

	@Override
	public void run(HelloWorldConfiguration configuration,
	                Environment environment)
	{
		final HelloWorldApi resource = new HelloWorldResource(
				configuration.getTemplate(),
				configuration.getDefaultName()
		);

		environment.jersey().register(resource);
		/**
		 * This is indented to put all resources under /api so that it does not conflict with the static content
		 */
		environment.jersey().setUrlPattern("/api/*");
	}

}