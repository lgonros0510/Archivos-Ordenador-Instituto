<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title> --- FICHA DEL VEHÍCULO --- </title>
            </head>
            <body>
                <h1>Ficha del Vehículo</h1>
                <table border="1">
                    <tr>
                        <td>Marca:</td>
                        <td><xsl:value-of select="vehiculo/marca"/></td>
                    </tr>
                    <tr>
                        <td>Página web:</td>
                        <td><a href="{vehiculo/web}"><xsl:value-of select="vehiculo/web"/></a></td>
                    </tr>
                    <tr>
                        <td>Modelo:</td>
                        <td><xsl:value-of select="vehiculo/modelo"/></td>
                    </tr>
                    <tr>
                        <td>Precio:</td>
                        <td><xsl:value-of select="concat('$', format-number(vehiculo/precio, '###,###.00'))"/></td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>