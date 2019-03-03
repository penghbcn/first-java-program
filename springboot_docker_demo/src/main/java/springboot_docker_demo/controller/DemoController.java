package springboot_docker_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot_docker_demo.mapper.alpha.AlphaMapper;
import springboot_docker_demo.mapper.beta.BetaMapper;

@RestController
public class DemoController {

	@Autowired
	private AlphaMapper alphaMapper;
	@Autowired
	private BetaMapper betaMapper;

	@RequestMapping("/test")
	public String ack() {
		return "This is DockerDemo!";
	}

	@RequestMapping("/db/alpha")
	public String queryAlpha() {
		return alphaMapper.selectNameById("1");
	}

	@RequestMapping("/db/beta")
	public String queryBeta() {
		return betaMapper.selectNameById("1");
	}

}
