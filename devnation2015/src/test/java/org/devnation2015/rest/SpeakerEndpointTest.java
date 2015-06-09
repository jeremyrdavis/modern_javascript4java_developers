package org.devnation2015.rest;

import javax.inject.Inject;

import org.devnation2015.model.Speaker;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SpeakerEndpointTest {

	@Inject
	private SpeakerEndpoint speakerEndpoint;
	
	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive archive = ShrinkWrap.create(JavaArchive.class).addClass(Speaker.class)
				.addClass(SpeakerEndpoint.class)
				.addClass(RestApplication.class)
				.addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(archive.toString(true));
		return archive;
	}

	@Test
	public void should_be_deployed() {
		Assert.assertNotNull(speakerEndpoint);
	}
}
