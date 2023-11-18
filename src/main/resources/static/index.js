// Add click event listeners to elements with class "btn" inside elements with class "info-item"
document.querySelectorAll(".info-item .btn").forEach(function(button) {
  button.addEventListener("click", function() {
    // Toggle the "log-in" class on elements with class "container"
    const containers = document.querySelectorAll(".container");
    containers.forEach(function(container) {
      container.classList.toggle("log-in");
    });
  });
});

// Add click event listeners to elements with class "btn" inside elements with class "container-form"
document.querySelectorAll(".container-form .btn").forEach(function(button) {
  button.addEventListener("click", function() {
    // Add the "active" class to elements with class "container"
    const containers = document.querySelectorAll(".container");
    containers.forEach(function(container) {
      container.classList.add("active");
    });
  });
});