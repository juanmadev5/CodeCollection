# Autor: JM Dev

# Script de conversión de archivos Word a PDF con docx2pdf.
# docx2pdf usa COM para interactuar con Microsoft Word en Windows.
# Por lo tanto solo funciona en equipos con Windows y Microsoft Word instalado.

import docx2pdf
import sys

def wordToPdf(file):
    docx2pdf.convert(file)
    print("Archivo Word convertido a PDF exitosamente :D")

if __name__ == "__main__":
    print("Script de conversión de archivos Word a PDF, by JM Dev")
    if len(sys.argv) > 1:
        wordToPdf(sys.argv[1])
    else:
        print("Uso: python wordToPdf.py <archivo.docx>")
