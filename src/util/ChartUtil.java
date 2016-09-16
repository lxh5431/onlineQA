package util;

import java.awt.Color;
import java.awt.Font;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.servlet.ChartDeleter;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class ChartUtil {
	public static String generatePieChart(DefaultPieDataset dataset,
			String titleName, int width, int height, HttpSession session,
			PrintWriter pw) {

		String filename = null;
		try {
			if (session != null) {
				ChartDeleter deleter = (ChartDeleter) session
						.getAttribute("JFreeChart_Deleter");
				session.removeAttribute("JFreeChart_Deleter");
				session.setAttribute("JFreeChart_Deleter", deleter);
			}
			// chart
			JFreeChart chart = ChartFactory.createPieChart3D(
					titleName, // title
					dataset,   // data
					false,      // include legend
					true, 
					false);
			
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			// 鍥剧墖涓樉绀虹櫨鍒嗘瘮:榛樿鏂瑰紡
			// plot.setLabelGenerator(new
			// StandardPieSectionLabelGenerator(StandardPieToolTipGenerator.DEFAULT_TOOLTIP_FORMAT));
			// 鍥剧墖涓樉绀虹櫨鍒嗘瘮:鑷畾涔夋柟寮忥紝{0} 琛ㄧず閫夐」锛� {1} 琛ㄧず鏁板�硷紝 {2} 琛ㄧず鎵�鍗犳瘮渚� ,灏忔暟鐐瑰悗涓や綅
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(),new DecimalFormat("0%")));
			// 鍥句緥鏄剧ず鐧惧垎姣�:鑷畾涔夋柟寮忥紝 {0} 琛ㄧず閫夐」锛� {1} 琛ㄧず鏁板�硷紝 {2} 琛ㄧず鎵�鍗犳瘮渚�
			//plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
			// 璁剧疆鑳屾櫙鑹蹭负鐧借壊
			chart.setBackgroundPaint(Color.white);
			// 鎸囧畾鍥剧墖鐨勯�忔槑搴�(0.0-1.0)
			plot.setForegroundAlpha(1.0f);
			// 鎸囧畾鏄剧ず鐨勯ゼ鍥句笂鍦嗗舰(false)杩樻き鍦嗗舰(true)
			plot.setCircular(true);
			// 瀹氫箟瀛椾綋鏍煎紡
			Font font = new java.awt.Font("榛戜綋", java.awt.Font.CENTER_BASELINE, 12);
			Font titleFont = new java.awt.Font("榛戜綋", java.awt.Font.CENTER_BASELINE, 15);
			TextTitle title = new TextTitle(titleName);
			title.setFont(titleFont);
			// 璁剧疆瀛椾綋,闈炲父鍏抽敭涓嶇劧浼氬嚭鐜颁贡鐮佺殑,涓嬫柟鐨勫瓧浣�
			//chart.getLegend().setItemFont(font);
			// 璁剧疆鍥剧墖鐨勫湴鍧�Pie鍥剧殑瀛椾綋
			plot.setLabelFont(font);
			chart.setTitle(title);
			
			// Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());
			// If the last parameter is null, the chart is a "one time"-chart
			// and will be deleted after the first serving.
			// If the last parameter is a session object, the chart remains
			// until session time out.
			filename = ServletUtilities.saveChartAsPNG(chart, width, height,
					info, session);
			// Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info, true);
			pw.flush();
		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());
			e.printStackTrace(System.out);
			filename = "picture_error.png";
		}
		return filename;
	}
}