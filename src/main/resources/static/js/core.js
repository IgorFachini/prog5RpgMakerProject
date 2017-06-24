$(document).ready(function() {
  // ================= NAVBAR ===========================
  $("#primary-navigation .close").click(function() {
      if ($("#primary-navigation .close").hasClass("open")) {
          $("#primary-navigation .close, #primary-navigation > ul").removeClass("open");
          $("body").removeClass("no-scroll");
      } else {
          $("#primary-navigation .close, #primary-navigation > ul").addClass("open");
          $("body").addClass("no-scroll");
      }
  });
  $("#primary-navigation ul li.has-children > a").click(function(e) {
      e.preventDefault();
      if (!$(this).parent().hasClass("open")) {
          $(this).parent().addClass("open");
      } else {
          $(this).parent().removeClass("open");
      }
  });
  $(window).resize(function() {
      if (window.innerWidth > 1000 && $("#primary-navigation > ul").hasClass("open")) {
          $("#primary-navigation .close, #primary-navigation > ul").removeClass("open");
          $("body").removeClass("no-scroll");
      }
  });
  // ==============================================================
});
