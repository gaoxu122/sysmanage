package com.framework.security.integral.web.util.date;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.ZoneId.SHORT_IDS;

/**
 * 时间操作工具类
 *
 * @author gaoxu
 */
@Slf4j
public class DateUtil {

    private static final int weekNum = 7;
    private static final int zero = 0;

    /**
     * 从时间戳转换成 LocalDateTime
     *
     * @param timestamp
     * @return
     */
    private static LocalDateTime timestamp(Long timestamp) {
        Date date = new Date(timestamp);
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.of(SHORT_IDS.get("CTT")));
    }

    /**
     * 以second为主进行判断
     * 以first为开始时间，second为结束时间
     * 判断两个时间是否在通过一个周内。
     *
     * @param first
     * @param second
     */
    private static Boolean checkWeekBetween(LocalDateTime first, LocalDateTime second) {
        // 两个时间差不超过7天,
        Period period = Period.between(first.toLocalDate(), second.toLocalDate());
        int years = period.getYears();
        log.info("years:{}", years);
        if (years > zero) {
            return false;
        }
        int months = period.getMonths();
        log.info("months:{}", months);
        if (months > zero) {
            return false;
        }
        int days = period.getDays();
        log.info("days:{}", days);
        if (days == zero) {
            // 表明是同一天
            return true;
        }
        if (days > weekNum || days < -weekNum) {
            // 两个时间差 超出了7天
            return false;
        }
        int firstDayOfWeek = first.getDayOfWeek().getValue();
        int secondDayOfWeek = second.getDayOfWeek().getValue();
        if (secondDayOfWeek == 1) {
            if (oneDay(firstDayOfWeek, secondDayOfWeek, days)) {
                return true;
            } else {
                return false;
            }
        }
        if (secondDayOfWeek == 7) {
            if (sevenDay(firstDayOfWeek, secondDayOfWeek, days)) {
                return true;
            } else {
                return false;
            }
        }
        if (otherDay(firstDayOfWeek, secondDayOfWeek, days)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * secondDayOfWeek 是所在星期的第一天
     * 星期的第一天 数据处理
     *
     * @return
     */
    private static Boolean oneDay(int firstDayOfWeek, int secondDayOfWeek, int days) {
        if (days > zero) {
            // 表明 first 比second 小 不在同一周
            return false;
        } else {
            // 表明 first 比second 大
            if (secondDayOfWeek - days == firstDayOfWeek) {
                return true;
            }
        }
        return false;
    }

    /**
     * 星期的第7天的时候处理数据
     *
     * @return
     */
    private static Boolean sevenDay(int firstDayOfWeek, int secondDayOfWeek, int days) {
        // second 是周日
        if (firstDayOfWeek + days == secondDayOfWeek) {
            return true;
        }
        return false;
    }

    /**
     * 其他天的数据处理
     *
     * @return
     */
    private static Boolean otherDay(int firstDayOfWeek, int secondDayOfWeek, int days) {
        if (days < 0) {
            // 表明 first 比 second 大
            if ((secondDayOfWeek - days) == firstDayOfWeek) {
                // 两者是 一周内
                return true;
            }
        } else {
            // 表明 first 比 second 小
            if (firstDayOfWeek + days == secondDayOfWeek) {
                // 两者是 一周内
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime second = LocalDateTime.parse("2016-12-31 14:18:20", formatter);
        LocalDateTime first = LocalDateTime.parse("2017-01-01 14:18:20", formatter);
//        以second 为准 判断是否在 同一周内
        log.info("firstDay:{},secondDay:{};是否是同一周：{}", first, second, checkWeekBetween(first, second));
        System.exit(0);
    }
}