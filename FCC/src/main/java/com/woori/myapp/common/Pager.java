package com.woori.myapp.common;

public class Pager {
    public static String makePage(int pagesize, int totalCnt, int curPage) {
        String tag = "";

        int pageTotal = (int) Math.ceil(totalCnt / (double) pagesize);
        int pageGroupSize = 10;
        int pageGroupStart = (curPage / pageGroupSize) * pageGroupSize;
        int pageGroupEnd = Math.min(pageGroupStart + pageGroupSize, pageTotal);
        
        tag += "<li class=\"page-item\">";
        tag += "<a class=\"page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center\" href=\"#\" onclick=\"goPage('0')\">";
        tag += "<i class=\"ti ti-chevrons-left\"></i>";
        tag += "</a>";
        tag += "</li>";

        tag += "<li class=\"page-item\">";
        tag += "<a class=\"page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center\" href=\"#\" onclick=\"goPage('" + (curPage - 1) + "')\">";
        tag += "<i class=\"ti ti-chevron-left\"></i>";
        tag += "</a>";
        tag += "</li>";

        for (int i = pageGroupStart; i < pageGroupEnd; i++) {
            if (i == curPage) {
                tag += "<li class=\"page-item active\" aria-current=\"page\">";
                tag += "<a class=\"page-link border-0 rounded-circle round-32 mx-1 d-flex align-items-center justify-content-center\" href=\"#\">" + (i + 1) + "</a>";
                tag += "</li>";
            } else {
                tag += "<li class=\"page-item\">";
                tag += "<a class=\"page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center\" href=\"#\" onclick=\"goPage('" + i + "')\">" + (i + 1) + "</a>";
                tag += "</li>";
            }
        }

        tag += "<li class=\"page-item\">";
        tag += "<a class=\"page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center\" href=\"#\" onclick=\"goPage('" + (curPage + 1) + "')\">";
        tag += "<i class=\"ti ti-chevron-right\"></i>";
        tag += "</a>";
        tag += "</li>";
        
        tag += "<li class=\"page-item\">";
        tag += "<a class=\"page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center\" href=\"#\" onclick=\"goPage('" + (pageTotal - 1) + "')\">";
        tag += "<i class=\"ti ti-chevrons-right\"></i>";
        tag += "</a>";
        tag += "</li>";

        return tag;
    }
}