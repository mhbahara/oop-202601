#!/usr/bin/env bash
# Menjalankan tes sampai minggu aktif (dibaca dari minggu-aktif.txt). Pemakaian: ./scripts/uji.sh [minggu]
set -euo pipefail
cd "$(dirname "$0")/.."

MINGGU="${1:-$(tr -d '[:space:]' < minggu-aktif.txt)}"
if ! [[ "$MINGGU" =~ ^[0-9]+$ ]] || [ "$MINGGU" -lt 1 ]; then
  echo "minggu-aktif.txt harus berisi angka >= 1 (isi sekarang: '$MINGGU')" >&2
  exit 2
fi

GROUPS_EXPR=""
for i in $(seq 1 "$MINGGU"); do
  GROUPS_EXPR="${GROUPS_EXPR:+$GROUPS_EXPR | }week$i"
done

echo "Menjalankan tes minggu 1 sampai $MINGGU  (groups: $GROUPS_EXPR)"
mvn -B -ntp test -Dgroups="$GROUPS_EXPR"
