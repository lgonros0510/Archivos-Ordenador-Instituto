<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title> --- TU CURRÍCULUM VITAE --- </title>
                <style>
                    table {
                        border-collapse: collapse;
                        width: 100%;
                    }
                    th, td {
                        border: 1px solid black;
                        padding: 8px;
                        text-align: left;
                    }
                </style>
            </head>
            <body>
                <h1>Curriculum Vitae</h1>
                <h2>Datos personales</h2>
                <p><strong>Nombre:</strong> <xsl:value-of select="curriculum/nombre"/></p>
                <p><strong>Teléfono:</strong> <xsl:value-of select="curriculum/contacto/telefono"/></p>
                <p><strong>Correo electrónico:</strong> <xsl:value-of select="curriculum/contacto/email"/></p>
                
                <h2>Formación académica</h2>
                <table>
                    <tr>
                        <th>Título o curso</th>
                        <th>Centro</th>
                        <th>Año de finalización</th>
                    </tr>
                    <xsl:for-each select="curriculum/formacion">
                        <tr>
                            <td><xsl:value-of select="titulo"/></td>
                            <td><xsl:value-of select="centro"/></td>
                            <td><xsl:value-of select="anio_finalizacion"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
                
                <h2>Experiencia profesional</h2>
                <table>
                    <tr>
                        <th>Puesto</th>
                        <th>Empresa</th>
                        <th>Año de inicio</th>
                        <th>Año de finalización</th>
                    </tr>
                    <xsl:for-each select="curriculum/experiencia">
                        <tr>
                            <td><xsl:value-of select="puesto"/></td>
                            <td><xsl:value-of select="empresa"/></td>
                            <td><xsl:value-of select="anio_inicio"/></td>
                            <td><xsl:value-of select="anio_finalizacion"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>