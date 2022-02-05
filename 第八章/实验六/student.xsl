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
						<th>生日</th>
						<th>成绩</th>
						<th>评价</th>
					</tr>
					<xsl:apply-templates select="/roster/student">
						<xsl:sort select="score" data-type="number" order="descending"/>
					</xsl:apply-templates>
					<tr>
						<th colspan="5">总分</th>
						<td align="center">
							<xsl:value-of select="sum(//score)"/>
						</td>
					</tr>
					<tr>
						<th colspan="5">总人数</th>
						<td align="center">
							<xsl:value-of select="count(//student)"/>
						</td>
					</tr>
					<tr>
						<th colspan="5">平均分</th>
						<td align="center">
							<xsl:value-of select="format-number(sum(//score) div count(//student),'#.0')"/>
						</td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="/roster/student">
			<tr>
				<xsl:choose>
					<xsl:when test="number(@ID) mod 2 = 0">
						<xsl:attribute name="bgcolor">green</xsl:attribute>		
						<td>
							<xsl:value-of select="@ID"/>
						</td>
						<td>
							<xsl:choose>
								<xsl:when test="sex='女'">
									<span style="color:blue">
										<xsl:value-of select="name"/>
									</span>
								</xsl:when>
								<xsl:otherwise>
									<span style="color:black">
										<xsl:value-of select="name"/>
									</span>
								</xsl:otherwise>
							</xsl:choose>
						</td>
						<td>
							<xsl:value-of select="sex"/>
						</td>
						<td>
							<xsl:value-of select="birthday"/>
						</td>
						<td>
							<xsl:value-of select="score"/>
						</td>
						<td align="center">
							<xsl:choose>
								<xsl:when test="score&lt;60">
									不及格
								</xsl:when>
								<xsl:when test="score &gt;=60 and score &lt;=80">
									一般
								</xsl:when>
								<xsl:when test="score &gt;80 and score &lt;=90">
									良好
								</xsl:when>
								<xsl:otherwise>
									优秀
								</xsl:otherwise>
							</xsl:choose>
						</td>
					</xsl:when>	
					<xsl:otherwise>
						<xsl:attribute name="bgcolor">white</xsl:attribute>		
						<td>
							<xsl:value-of select="@ID"/>
						</td>
						<td>
							<xsl:choose>
								<xsl:when test="sex='女'">
									<span style="color:blue">
										<xsl:value-of select="name"/>
									</span>
								</xsl:when>
								<xsl:otherwise>
									<span style="color:black">
										<xsl:value-of select="name"/>
									</span>
								</xsl:otherwise>
							</xsl:choose>
						</td>
						<td>
							<xsl:value-of select="sex"/>
						</td>
						<td>
							<xsl:value-of select="birthday"/>
						</td>
						<td>
							<xsl:value-of select="score"/>
						</td>
						<td align="center">
							<xsl:choose>
								<xsl:when test="score&lt;60">
									不及格
								</xsl:when>
								<xsl:when test="score &gt;=60 and score &lt;=80">
									一般
								</xsl:when>
								<xsl:when test="score &gt;80 and score &lt;=90">
									良好
								</xsl:when>
								<xsl:otherwise>
									优秀
								</xsl:otherwise>
							</xsl:choose>
						</td>
					</xsl:otherwise>	
				</xsl:choose>		
			</tr>
	</xsl:template>
</xsl:stylesheet>