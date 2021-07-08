<script>

    document.addEventListener("DOMContentLoaded", () => {
        document.querySelector("table").addEventListener("click", () => {
            alert("시설 상세 페이지로 이동합니다.")
            location.href = "search_detail.html";
        });
    });

</script>