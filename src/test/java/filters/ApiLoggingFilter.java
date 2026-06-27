package filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ApiLoggingFilter implements Filter {

	private static final Logger log = LogManager.getLogger(ApiLoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification req, FilterableResponseSpecification res, FilterContext ctx) {

		log.info("URI: " + req.getURI());
		log.info("Body: " + req.getBody());

		Response response = ctx.next(req, res);

		log.info("Status: " + response.getStatusCode());
		log.info("Response: " + response.asPrettyString());

		return response;
	}
}