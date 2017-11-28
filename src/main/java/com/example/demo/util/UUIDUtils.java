package com.example.demo.util;

import java.util.UUID;

/**
 * @author sunjian.
 */
public class UUIDUtils
{
    public static String getUUID()
    {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
