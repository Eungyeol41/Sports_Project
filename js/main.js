<script>
document.addEventListener("DOMContentLoaded", () => {
        // 1번 Box 클릭
        document.querySelector("div#box1").addEventListener("click", () => {
            location.href = "search_page.html";
        });

  // 2번 Box 클릭
  document.querySelector("div#box2").addEventListener("click", () => {
        location.href = "map_page.html";
  });

  // 3번 Box 클릭
  document.querySelector("div#box3").addEventListener("click", () => {
        location.href = "3번Box.html";
  });
});
</script>