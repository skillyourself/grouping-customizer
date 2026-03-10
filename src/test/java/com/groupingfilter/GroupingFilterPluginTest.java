package com.groupingfilter;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GroupingFilterPluginTest
{
    public static void main(String[] args) throws Exception
    {
        ExternalPluginManager.loadBuiltin(GroupingFilterPlugin.class);
        RuneLite.main(args);
    }
}