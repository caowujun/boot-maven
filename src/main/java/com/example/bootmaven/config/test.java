//package com.example.bootmaven.config;
//
//import java.time.LocalDateTime;
//
//public interface   fTransfer    extends MapStructConvertor<Sysuser,SysuserVO>
//        {
//
//            @Override
//            SysuserVO d2v(Sysuser sysuser);
//
//            @Override
//            Sysuser v2d(SysuserVO sysuserVO);
//
//            @Override
//            default String parseString(LocalDateTime date) {
//                return null;
//            }
//
//            @Override
//            default LocalDateTime parseDate(String date) {
//                return null;
//            }
////        }