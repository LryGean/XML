<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!---输出类型-->
	<xsl:output method="html" encoding="GB2312"/>
	<!--模板-->
	<xsl:template match="/">
		<html>
			<body>
				<xsl:for-each select="roster/student">
					<!--排序，descending-->
					<xsl:sort select="score" data-type="number"/>
						<p>
							<!--信息提取输出-->
							<xsl:value-of select="@ID"/>
						</p>
						<p>
							<xsl:value-of select="name"/> 
						</p>
						<p>
							<xsl:value-of select="sex"/>
						</p>
						<p>
							<xsl:value-of select="score"/>
						</p>
					<hr/>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>