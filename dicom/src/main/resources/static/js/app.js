document.addEventListener('DOMContentLoaded', () => {
    // cornerstone 초기화
    cornerstoneWADOImageLoader.external.cornerstone = cornerstone;
    cornerstoneWADOImageLoader.external.cornerstoneTools = cornerstoneTools;

    // 이미지를 넣을 요소 얻어오기
    const element = document.getElementById('dicomImage');
    const elementWebGL = document.getElementById('dicomImageWebGL');
    const elementCanvas = document.getElementById('dicomImageCanvas');

    // cornerstone 요소 활성화
    cornerstone.enable(element);
    cornerstone.enable(elementWebGL);
    cornerstone.enable(elementCanvas);

    // 이미지 얻어오기
    const imageId = 'wadouri:img/MR.1.2.392.200036.9116.4.1.6116.40033.5.3001.1.1152393810.dcm';

    function onImageRendered(e) {
        const eventData = e.detail;

        cornerstone.setToPixelCoordinateSystem(eventData.enabledElement, eventData.canvasContext);

        const parent = eventData.element.parentNode;
        parent.querySelector('.renderTime').textContent = "Render Time:" + eventData.renderTimeInMs + " ms";
        parent.querySelector('.wwwc').textContent = "WW/WL:" + Math.round(eventData.viewport.voi.windowWidth)
            + "/" + Math.round(eventData.viewport.voi.windowCenter);
    }

    element.addEventListener('cornerstoneimagerendered', onImageRendered);
    elementWebGL.addEventListener('cornerstoneimagerendered', onImageRendered);
    elementCanvas.addEventListener('cornerstoneimagerendered', onImageRendered);

    cornerstone.loadAndCacheImage(imageId).then(function(image) {
        cornerstone.displayImage(element, image);
        cornerstone.displayImage(elementWebGL, image);
        cornerstone.displayImage(elementCanvas, image);
    });

    const elements = [element, elementWebGL, elementCanvas];
    elements.forEach(function(elem) {
        // add event handlers to mouse move to adjust window/center
        elem.addEventListener('mousedown', function (e) {
            let lastX = e.pageX;
            let lastY = e.pageY;

            function mouseMoveHandler(e) {
                const deltaX = e.pageX - lastX;
                const deltaY = e.pageY - lastY;
                lastX = e.pageX;
                lastY = e.pageY;

                let viewport = cornerstone.getViewport(elem);
                viewport.voi.windowWidth += (deltaX / viewport.scale);
                viewport.voi.windowCenter += (deltaY / viewport.scale);
                cornerstone.setViewport(elem, viewport);
            }

            function mouseUpHandler() {
                document.removeEventListener('mousemove', mouseMoveHandler);
                document.removeEventListener('mouseup', mouseUpHandler);
            }

            document.addEventListener('mousemove', mouseMoveHandler);
            document.addEventListener('mouseup', mouseUpHandler);
        });
    });
});
