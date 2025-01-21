# Autor: JM Dev

# Script de conversión de archivos Word a PDF con docx2pdf.
# docx2pdf usa COM para interactuar con Microsoft Word en Windows.
# Por lo tanto solo funciona en equipos con Windows y Microsoft Word instalado.

import docx2pdf
import sys
import os
import contextlib

def suppress_output(func, *args, **kwargs):
    with open(os.devnull, 'w') as fnull:
        with contextlib.redirect_stdout(fnull), contextlib.redirect_stderr(fnull):
            return func(*args, **kwargs)

def wordToPdf(file):
    suppress_output(docx2pdf.convert, file, output_path="C:/Users/juanm/Downloads")
    print("")
    print("✅ Archivo Word convertido a PDF exitosamente :D")
    print("")
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
