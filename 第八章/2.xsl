<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="GB2312"/>
	<xsl:template match="/">
		<html>
			<body>
				<table align="center" border="4">
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>成绩</th>
					</tr>
					<xsl:apply-templates select="/roster/student">
						<xsl:sort select="score" data-type="number" order="descending"/>
					</xsl:apply-templates>
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="/roster/student">
		<tr>
			<td>
				<xsl:value-of select="@ID"/>
			</td>
			<td>
				<xsl:if test="sex='女'">
					<xsl:attribute name="bgcolor">blue</xsl:attribute>
				</xsl:if>
				<xsl:value-of select="name"/>
			</td>
			<td>
				<xsl:value-of select="sex"/>
			</td>
			<td>
				<xsl:value-of select="score"/>
			</td>
		</tr>
	
	</xsl:template>
</xsl:stylesheet>