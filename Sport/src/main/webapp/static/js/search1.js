  let urlPath = `${rootPath}`;
  
    function checkSelectAll() {
        const checkbox = document.querySelectorAll('input[name="ch"]');
    	const checked = document.querySelectorAll('input[name="ch"]:checked');
    	const selectAll = document.querySelector('input[name="ch_a-ll"]');

    if (checkbox.length === checked.length) {
        selectAll.checked = true;
        } else {
        selectAll.checked = false;
        }
    }

      document.addEventListener("DOMContentLoaded", () => {

    document
    .querySelector('input[name="ch_all"]')
    .addEventListener("change", function (e) {
        e.preventDefault();
    let list = document.querySelectorAll('input[name="ch"]');
    for (let i = 0; i < list.length; i++) {
        list[i].checked = this.checked;
            }
          });

    let objs = document.querySelectorAll("input#ch");
    for (let i = 0; i < objs.length; i++) {
        objs[i].addEventListener(
            "click",
            () => {
                let selectAll = document.querySelector("input#all");
                for (let j = 0; j < objs.length; j++) {
                    if (objs[j].checked === false) {
                        selectAll.checked = false;
                        return;
                    }
                }
                selectAll.checked = true;
            },
            false
        );
        }
      });
