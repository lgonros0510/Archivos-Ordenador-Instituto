<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="A4" page-heigth="29.7cm" page-width="21cm" margin="0.2cm">
            </fo:simple-page-master>
            <fo:region-body margin-top="1cm"/>
            <fo:region-before extent="2cm"/>
            <fo:region-after extent="2cm"/>
            <fo:region-start extent="3cm"/>
            <fo:region-end extent="2cm"/>
        </fo:layout-master-set>
        <fo:flow flow-name="xsl-region-body">
            <fo:block font-size="8pt" font-family="sans-serif" color="darkgreen">
                <xsl:value-of select="espacio_protegido/descripcion"/>
            </fo:block>
        </fo:flow>

        <fo:flow flow-name="xsl-region-before">
            <fo:block font-size="8pt" font-family="sans-serif" color="darkgreen" text-align="center">
                <xsl:value-of select="espacio_protegido/nombre"/>
            </fo:block>
        </fo:flow>

        <fo:flow flow-name="xsl-region-after">
            <fo:block font-size="8pt" font-family="sans-serif" color="red">
                <xsl:value-of select="espacio_protegido/provincias/provincia"/>
            </fo:block>
        </fo:flow>

        <fo:flow flow-name="xsl-region-start">
            <fo:block font-size="8pt" font-family="sans-serif" background-color="darkgreen" color="white">
                <xsl:value-of select="espacio_protegido/tipo"/>
            </fo:block>
        </fo:flow>

        <fo:flow flow-name="xsl-region-end">
            <fo:block font-size="8pt" font-family="sans-serif" color="blue">
                <xsl:value-of select="espacio_protegido/actividades/actividad"/>
            </fo:block>
        </fo:flow>
    </xsl:template>
</xsl:stylesheet>