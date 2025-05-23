function removeCart(remove_btn) {
    let pID = $(remove_btn).data('id'); // Lấy ID sản phẩm
    console.log("Sản phẩm cần xóa có ID là: " + pID);

    if(confirm("Bạn có chắc chắn muốn xóa không?")){
        $.ajax({
            url: "remove-cart",
            data: {
                pID: pID,
            },
            success: function (response) {
                console.log(response)
                if (response.isSuccess) {
                    $(`div[data-id="${pID}"]`).remove();
                    // formatted trước khi cập nhật
                    $(".subtotalQuantity").text(response.TotalQuantity);
                    $(".total-cart").text(formatCurrency(response.Total));

                    function formatCurrency(value) {
                        return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(value);
                    }
                    let value=response.TotalQuantity
                    console.log(value)
                    updateQuantity(value)
                } else {
                    alert("Xóa sản phẩm không thành công.");
                }
            },
            error: function () {
                alert("Lỗi xảy ra trong quá trình xóa sản phẩm.");
            }
        });
    }


}
