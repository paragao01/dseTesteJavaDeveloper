#!/bin/bash
# Script para fazer push do código para o repositório GitHub
# Execute este script APÓS criar o repositório 'dseTesteJavaDeveloper' no GitHub

echo "=========================================="
echo "Push para GitHub - dseTesteJavaDeveloper"
echo "=========================================="
echo ""

# Solicita o username do GitHub
read -p "Digite seu username do GitHub: " GITHUB_USER

if [ -z "$GITHUB_USER" ]; then
    echo "Erro: Username não pode ser vazio!"
    exit 1
fi

# Configura o remote
echo "Configurando remote..."
git remote remove origin 2>/dev/null
git remote add origin "https://github.com/${GITHUB_USER}/dseTesteJavaDeveloper.git"

# Garante que estamos na branch main
git branch -M main

# Faz o push
echo "Fazendo push para o GitHub..."
git push -u origin main

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Sucesso! Código enviado para:"
    echo "   https://github.com/${GITHUB_USER}/dseTesteJavaDeveloper"
else
    echo ""
    echo "❌ Erro ao fazer push. Verifique:"
    echo "   1. Se o repositório foi criado no GitHub"
    echo "   2. Se você tem permissões de escrita"
    echo "   3. Se suas credenciais estão configuradas"
fi

