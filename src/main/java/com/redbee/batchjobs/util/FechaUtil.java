package com.redbee.batchjobs.util;

import org.joda.time.DateTime;

import java.util.Date;

public class FechaUtil {

    /**
     * Instancia un Date.
     *
     * @return date.
     */
    public static Date getNewDate() {
        return new Date();
    }

    /**
     * Instancia un DateTime.
     *
     * @return datetime.
     */
    public static DateTime getNewDateTime() {
        return new DateTime();
    }

    /**
     * @param date de la cual se desea el datetime.
     * @return DateTime del date.
     */
    public static DateTime getDateTime(Date date) {
        return new DateTime(date);
    }

    /**
     * @param date a la cual se le va a restar media hora.
     * @return la fecha con media hora menos.
     */
    public static Date restarMediaHora(Date date) {
//        return getDateTime(date).minusHours(1).toDate();
        return getDateTime(date).minusMinutes(30).toDate();
    }

    /**
     * @param date a la cual se le va a restar una hora.
     * @return la fecha con una hora menos.
     */
    public static Date restarHora(Date date) {
        return getDateTime(date).minusHours(1).toDate();
    }
}
