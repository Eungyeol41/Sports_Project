<script>
        document.addEventListener("DOMContentLoaded", () => {
        document.querySelector("button#enter").addEventListener("click", () => {
            alert("1대 1 문의 페이지로 이동합니다.");
            location.href = "Q&A_list.html";
        });
            document.querySelector("button#reset").addEventListener("click", () => {
        alert("내용이 reset됩니다.");
            });
        });
</script>