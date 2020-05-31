package org.mysise.authentication.nacosconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController
@RefreshScope
public class SampleController {

    @Value("${user.name}")
    String userName;

    @Value("${user.age:25}")
    int age;

    @RequestMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + age + "!";
    }
}
