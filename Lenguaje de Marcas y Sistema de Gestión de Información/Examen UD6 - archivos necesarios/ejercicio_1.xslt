<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                -- Ejercicio 1 || Examen Tema 6 LMSGI --
            </head>
            <body>
                <table border="1">
                    <tr>
                        <th>Modelo del coche</th>
                        <th>Fecha de su salida al mercado</th>
                        <th>Precio actual del coche</th>
                        <th>Ventas totales del coche</th>
                    </tr>
                    <xsl:for-each select="coches/coche">
                        <xsl:sort select="modelo"/>
                            <tr>
                                <td><xsl:value-of select="@nombre"/></td>
                                <td><xsl:value-of select="modelo"/></td>
                                <td><xsl:value-of select="salida"/></td>
                            </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>