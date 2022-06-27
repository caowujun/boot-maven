//package com.example.bootmaven.tools;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.robin.boot.entity.Sysuser;
//
//
//import java.util.Date;
//
///**
// * @program: gmnfdc
// * @description: token，jwt
// * @author: caowujun
// * @create: 2020-05-11 15:48
// **/
//public class JwtUtil {
//
//    //过期时间
//    private static final long EXPIRE_TIME = 120 * 60 * 1000;
//    //私钥
//    private static final String TOKEN_SECRET = "robin_privatekey";
//
//    /**
//     * @param user
//     * @Author wujun.cao
//     * @Description 返回加密jwt
//     * @Date Created in 2021/03/18 15:13
//     * @Return {@link java.lang.String}
//     **/
//    public static String createToken(Sysuser user) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//
//            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
//            // 设置过期时间
//            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
//            // 私钥和加密算法
//            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//
//            // 返回token字符串
//            return JWT.create().withIssuer("auth0").withSubject(json)
//                    .withClaim("loginname", user.getUsername())
//                    .withClaim("cnname", user.getCnname())
//                    .withClaim("id", user.getId())
//                    .withExpiresAt(date).sign(algorithm);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * @param token
//     * @Author wujun.cao
//     * @Description 验证token是否有效
//     * @Date Created in 2021/03/18 15:13
//     * @Return {@link boolean}
//     **/
//    public static boolean verifyToken(String token) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
//            JWTVerifier verifier = JWT.require(algorithm)
//                    .withIssuer("auth0")
//                    .build(); //Reusable verifier instance
//            DecodedJWT jwt = verifier.verify(token);
//            return true;
//        } catch (JWTVerificationException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * @param token
//     * @param key
//     * @Author wujun.cao
//     * @Description 获取token里的私有值
//     * @Date Created in 2021/03/18 15:14
//     * @Return {@link java.lang.String}
//     **/
//    public static String getClaim(String token, String key) {
//        try {
//
//            DecodedJWT jwt = JWT.decode(token);
//            return jwt.getClaim(key).asString();
//        } catch (JWTVerificationException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
