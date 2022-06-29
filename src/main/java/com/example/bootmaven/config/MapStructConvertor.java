//package com.example.bootmaven.config;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import org.mapstruct.Named;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public interface MapStructConvertor   {
//
//
//    //-------------------------------------------------------------------------------------------------------------------------------
//    /*
//     * @author robin
//     * @description 不能单独定义成一行，比如 // DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//     * @date 2022/6/28 15:38
//     * @param date
//     * @return java.lang.String
//     */
//    @Named("parseString")
//    default String parseString(LocalDateTime date) {
//        try {
//            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(date);
//        } catch (Exception ex) {
//            return null;
//        }
//    }
//
//    /*
//     * @author robin
//     * @description  不能单独定义成一行，比如 // DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//     * @date 2022/6/28 15:38
//     * @param date
//     * @return java.time.LocalDateTime
//     */
//    @Named("parseDate")
//    default LocalDateTime parseDate(String date) {
//        try {
//            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        } catch (Exception ex) {
//            return null;
//        }
//    }
//}
