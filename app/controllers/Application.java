package controllers;

import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class Application extends Controller {

	public Result index() {
		return ok();
	}

	@BodyParser.Of(value = BodyParser.MultipartFormData.class)
	public Result upload() {
		Http.MultipartFormData body = request().body().asMultipartFormData();
		final Http.MultipartFormData.FilePart filePart = body.getFile("file");
		return ok("{\"fileType:\":" + filePart.getContentType() + "}");
	}

}
