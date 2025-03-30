# Autor: JM Dev

# Script de conversión de archivos Word a PDF con docx2pdf.
# Este script solo puede funcionar en equipos Windows y MacOS con Microsoft Office (Word) instalados.
# Requiere tener instalado docx2pdf, instalar usando pip install docx2pdf

import docx2pdf
import sys
import os
import contextlib

def suppress_output(func, *args, **kwargs):
    with open(os.devnull, 'w') as fnull:
        with contextlib.redirect_stdout(fnull), contextlib.redirect_stderr(fnull):
            return func(*args, **kwargs)

def wordToPdf(file):
    suppress_output(docx2pdf.convert, file, output_path="C:/Users/Public")
    print("")
    print("✅ Archivo Word convertido a PDF exitosamente :D")
    print("Ubicacion: C:/Users/Public")
    print("")

if __name__ == "__main__":
    print("")
    print("")
    print("🚀 Script de conversión de archivos Word a PDF, by JM Dev")
    print("🛠️ Conviertiendo archivo...")
    if len(sys.argv) > 1:
        wordToPdf(sys.argv[1])
    else:
        print("⚠️ Uso: python wordToPdf.py <archivo.docx>")
