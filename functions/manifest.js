exports.handler = async (event, context) => {
    const manifest = {
        "name": "Better Internet Initiative",
        "short_name": "Better Internet",
        "start_url": "/index.html",
        "display": "standalone",
        "background_color": "#ffffff",
        "theme_color": "#007BFF",
        "description": "Essential resources for internet security and freedom. We protect human rights!",
        "icons": [
            {
                "src": "icons/icon-192x192.png",
                "sizes": "192x192",
                "type": "image/png"
            },
            {
                "src": "icons/icon-512x512.png",
                "sizes": "512x512",
                "type": "image/png"
            }
        ]
    };

    return {
        statusCode: 200,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(manifest),
    };
};
