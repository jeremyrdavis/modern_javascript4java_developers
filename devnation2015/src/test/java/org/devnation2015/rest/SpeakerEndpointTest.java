package org.devnation2015.rest;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.devnation2015.model.Speaker;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

@RunWith(Arquillian.class)
public class SpeakerEndpointTest {

	@PersistenceContext(unitName = "devnation2015-persistence-unit-test")
	private EntityManager em;

	@Inject
	private SpeakerEndpoint speakerEndpoint;
	
	private static String deploymentUrl;

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		WebArchive archive = ShrinkWrap
				.create(WebArchive.class)
				.addClass(Speaker.class)
				.addClass(SpeakerEndpoint.class)
				.addClass(RestApplication.class)
				.addAsResource("META-INF/persistence.xml",
						"META-INF/persistence.xml")
				.addAsResource("import.sql", "import.sql")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(archive.toString(true));
		deploymentUrl = (archive.toString().split("\\."))[0];
		System.out.println("Deployment URL : " + deploymentUrl);
		return archive;
	}

	@Test
	public void testSpeakerFetchesSuccess() {
		Response response = RestAssured.get("/" + deploymentUrl + "/rest/speakers/1");
		expect().body("id", equalTo(1)).body("firstname", equalTo("Jeremy"))
				.body("lastname", equalTo("Davis"))
				.body("bio", equalTo("A really great speaker"))
				.when().get("/" + deploymentUrl + "/rest/speakers/1");
	}

	@PostConstruct
	public void loadData() {
		Speaker jeremy = new Speaker(1L, 1, "Jeremy", "Davis",
				"A really great presenter", "@argntprgrmr");
		Speaker brian = new Speaker(1L, 1, "Brian", "Ashburn",
				"A really great presenter", "@bkashburn");
		em.persist(jeremy);
		em.persist(brian);
	}
}
