package javacontribute.javaspringboot.web;

import javacontribute.javaspringboot.entity.FilterEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Lijie
 * @Date: 2018/12/25 10:25
 */
@Controller
public class ParameterController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParameterController.class);

    @RequestMapping(value = "/filterTest", method = RequestMethod.POST)
    public void filterTest(@RequestBody FilterEntity filterEntity, HttpServletRequest request){
        LOGGER.info("request:{}", request.getParameter("filterEntity"));
        LOGGER.info("filterEntity:{}", filterEntity.toString());
    }
}
