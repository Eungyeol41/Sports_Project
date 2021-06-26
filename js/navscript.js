document.addEventListener("DOMContentLoaded", () => {
  document.querySelector("nav#main_nav img").addEventListener("click", () => {
    location.href = "search_page.html";
  });
  document
    .querySelector("nav#main_nav li:nth-child(1)")
    .addEventListener("click", () => {
      location.href = "search_page.html";
    });
  document.querySelector("nav#main_nav").addEventListener("click", () => {
    location.href = "main_page copy.html";
  });
});
