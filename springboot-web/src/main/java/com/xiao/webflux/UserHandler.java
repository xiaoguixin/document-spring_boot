package com.xiao.webflux;

import com.xiao.entity.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * webFlux-函数式
 * 用户处理类
 */
@Component
public class UserHandler {

    /**
     * mono获取用户信息
     * @param request
     * @return
     */
    public Mono<ServerResponse> getMonoUser(ServerRequest request) {
        String id = request.pathVariable("user");
        Integer userId = Integer.valueOf(id);
        List<User> users = User.getUsers(userId.intValue());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(users.get(userId-1)));
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("delete, City!"));
    }
}
