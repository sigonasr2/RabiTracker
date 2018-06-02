package sig.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DebugUtils {
	public static void showStackTrace() {
		System.out.println("Trace:"+getStackTrace());
	}
	
	public static String getStackTrace() {
		StackTraceElement[] stacktrace = new Throwable().getStackTrace();
		StringBuilder stack = new StringBuilder("Mini stack tracer:");
		for (int i=0;i<Math.min(10, stacktrace.length);i++) {
			stack.append("\n"+stacktrace[i].getClassName()+": **"+stacktrace[i].getFileName()+"** "+stacktrace[i].getMethodName()+"():"+stacktrace[i].getLineNumber());
		}
		return stack.toString();
	}

	public static void outputHashmap(HashMap map) {
		StringBuilder builder = new StringBuilder();
		for (Object o : map.keySet()) {
			Object val = map.get(o);
			builder.append(o.toString()+": ");
			if (val instanceof List) {
				builder.append("\n");
				boolean first=true;
				for (Object obj : (List)val) {
					if (first) {
						builder.append("  "+obj.toString());
					} else {
						builder.append("\n  "+obj.toString());
					}
				}
			} else 
			if (val instanceof Map) {
				builder.append("\n");
				boolean first=true;
				for (Object obj : ((Map) val).keySet()) {
					if (first) {
						builder.append("  "+obj.toString()+": "+((Map) val).get(obj).toString());
					} else {
						builder.append("\n  "+obj.toString()+": "+((Map) val).get(obj).toString());
					}
				}
			} else {
				builder.append(val.toString());
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}
}

