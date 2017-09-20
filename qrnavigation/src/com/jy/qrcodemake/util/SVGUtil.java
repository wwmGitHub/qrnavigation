package com.jy.qrcodemake.util;

import java.util.ArrayList;
import java.util.List;

public class SVGUtil {
	/**
	 * 
	 * @param svg
	 * @return
	 */
	public static List<String> getSvgsFromString(String svg){
		List<String> svgList = new ArrayList<String>();
		svgList = GlobalFunc.getStringBetween(svgList, svg, "<svg ", "</svg>");
		return svgList;
	}
	/**
	 * //stroke=\"rgba(192,192,192,0.0001)\",需要对其进行替换
		//stoke=\"#C0C0C0\" sroke-opacity=\"0.0001\"
		//fill=\"rgba(255,255,255,0)\"
		//style=\"fill:#FFFFFF;fill-opacity:0;\"
	 * @param svg
	 * @return
	 */
	public static String replaceRgba(String svg){
		
		return svg;
	}
}
